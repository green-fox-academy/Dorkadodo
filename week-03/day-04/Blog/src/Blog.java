import java.util.ArrayList;

public class Blog {
    private ArrayList<BlogPost> blog;
    public Blog(){
        blog = new ArrayList<>();
    }

    public ArrayList<BlogPost> getBlog (){
        return blog;
    }

    public void setBlog(ArrayList<BlogPost> blog){
        this.blog=blog;
    }

    public void addBlogPost (BlogPost blogPost){
        blog.add(blogPost);
    }

    public BlogPost getBlogPost (int index){
        return blog.get(index);
    }
    public void deleteBlogPost (int index){
        blog.remove(index);
    }
    public void updateBlogPost (int index, BlogPost blogPost){
        blog.set(index, blogPost);
    }
}
