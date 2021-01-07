package com.greenfoxacademy.bank.collectors;

import com.greenfoxacademy.bank.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BankAccountController {

    private List<BankAccount> accountList = new ArrayList<>();

    public BankAccountController() {
        accountList.add(new BankAccount("Simba", 2000, "lion", true, true));
        accountList.add(new BankAccount("Nala", 3000, "lion", false, true));
        accountList.add(new BankAccount("Timon", 2530, " meerkat", false, false));
        accountList.add(new BankAccount("Pumba", 230, "warthog", false, false));
        accountList.add(new BankAccount("Zazu", 5300, "red-billed hornbill", false, true));
        accountList.add(new BankAccount("Kovu", 1200, "lion", true, true));
    }

    @GetMapping("/show")
    public String show(Model model) {
        BankAccount account = new BankAccount("Simba", 2000, "lion", true, true);
        model.addAttribute("account", account);
        return "details";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("accountList", accountList);
        return "list";
    }

    @PostMapping("/increase")
    public String increase(@RequestParam Long accountId) {
        Optional<BankAccount> requestedAccount = accountList.stream()
                .filter(f -> f.getId() == accountId)
                .findFirst();
        if (requestedAccount.isPresent()) {
            BankAccount chosenAccount = requestedAccount.get();
            chosenAccount.setBalance(chosenAccount.getKing() ? (chosenAccount.getBalance() + 100) : (chosenAccount.getBalance() + 10));
        }
        return "redirect:/list";
    }

    @PostMapping("/new-account")
    public String newAccount(@RequestParam BankAccount account, Model model){
        accountList.add(account);
        return "redirect:/list";
    }

    @GetMapping("/thing")
    public String thing(Model model) {
        String thing = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("thing", thing);
        return "strangething";
    }
}
