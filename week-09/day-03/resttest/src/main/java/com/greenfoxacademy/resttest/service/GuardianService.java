package com.greenfoxacademy.resttest.service;

import com.greenfoxacademy.resttest.model.*;
import com.greenfoxacademy.resttest.repo.AmmunitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardianService {

    @Autowired
    private AmmunitionRepository ammunitionRepository;
    private Ammunition ammunition;

    public GrootTranslator translateToGroot(String message){
        return new GrootTranslator(message);
    }

    public ErrorMessage error(String message){
        return new ErrorMessage(message);
    }

    public SpeedCalculator youndusArrow (Double distance, Double time){
        return new SpeedCalculator(distance, time);
    }

    public String getCargoStatus (){
        ammunition = new Ammunition();
        Double cargoAmount = calculateCargoAmount();
        Integer fullCapacity = ammunition.getFullShipCapacity();
        Double cargoPercent = ((cargoAmount / fullCapacity) * 100);
        if (cargoPercent == 0){
            return "empty";
        }
        if (cargoPercent == 100){
            return "full";
        }
        if (cargoPercent > 100){
            return "overloaded";
        }
        return (cargoPercent).intValue() + "%";
    }

    private Double calculateCargoAmount(){
        Double currentAmount = Double.valueOf(((List<Ammunition>)ammunitionRepository.findAll()).stream()
                .map(ammunition -> ammunition.getAmount())
                .reduce(0, (am1, am2) -> am1 + am2));
        return currentAmount;
    }

    public WholeCargoDTO getListOfCargo (){
        WholeCargoDTO cargo = new WholeCargoDTO();
        cargo.setCaliber25(ammunitionRepository.findByCaliber(".25").getAmount());
        cargo.setCaliber30(ammunitionRepository.findByCaliber(".30").getAmount());
        cargo.setCaliber50(ammunitionRepository.findByCaliber(".50").getAmount());
        cargo.setShipstatus(getCargoStatus());
        cargo.setReady(cargo.getShipstatus().equals("full")? true : false);
        return cargo;
    }

    public Boolean isExistingCaliber (String caliber){
        List<String> caliberList = ((List<Ammunition>)ammunitionRepository.findAll()).stream()
                .map(ammunition1 -> ammunition1.getCaliber())
                .collect(Collectors.toList());
        if (caliberList.contains(caliber)){
            return true;
        }
        return false;
    }

    public Boolean isValidAmount(Integer amount){
        if (amount <= 0){
            return false;
        }
        return true;
    }

    public ReceivedAmmunitionDTO fillCargoAndAnswer(String caliber, Integer amount){
        Ammunition receivedAmmunition = ammunitionRepository.findByCaliber(caliber);
        receivedAmmunition.setAmount(receivedAmmunition.getAmount() + amount);
        ammunitionRepository.save(receivedAmmunition);
        return createReceivedAmmunitionAnswer(caliber, amount);
    }

    public void setAmountOfAmmo(String caliber, Integer amount){
        Ammunition receivedAmmunition = ammunitionRepository.findByCaliber(caliber);
        if (receivedAmmunition == null){
            ammunitionRepository.save(new Ammunition(caliber));
            return;
        }
        receivedAmmunition.setAmount(amount);
        ammunitionRepository.save(receivedAmmunition);
    }

    private ReceivedAmmunitionDTO createReceivedAmmunitionAnswer (String caliber, Integer amount){
        String shipstatus = getCargoStatus();
        Boolean ready = (shipstatus.equals("full")? true : false);
        return new ReceivedAmmunitionDTO(caliber, amount, shipstatus, ready);
    }

    public void addNewTypeOfAmmo (String caliber){
        ammunitionRepository.save(new Ammunition(caliber));
    }

}
