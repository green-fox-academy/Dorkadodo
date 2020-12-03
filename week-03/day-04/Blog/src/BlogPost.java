public class BlogPost {
    private String authorName;
    private String title;
    private String text;
    private String publicationDate;

    public String getAuthorName (){
        return authorName;
    }
    public String getTitle (){
        return title;
    }
    public String getText (){
        return text;
    }
    public String getPublicationDate (){
        return publicationDate;
    }

     public void setAuthorName (String authorName){
        this.authorName = authorName;
     }
     public void setTitle (String title){
        this.title= title;
     }
     public void setText(String text){
        this.text=text;
     }
     public void setPublicationDate (String publicationDate)   {
        this.publicationDate=publicationDate;
     }
    public BlogPost (String authorName, String title, String publicationDate) {}
}
