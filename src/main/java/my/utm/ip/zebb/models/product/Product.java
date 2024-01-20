package my.utm.ip.zebb.models.product;

public class Product {
    String id;
    String category;
    String name;
    String description;
    double price;

    public Product() {
    this.id="";
    this.category="";
    this.name="";
    this.description="";
    this.price=0.0;

    }

    public Product(String id, String category, String name, String description, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }

        // Util methods

    public Product copy() {
        return new Product(this.id, this.category, this.name, this.description, this.price);
    }

    public void assign(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.category = product.category;
        this.description = product.description;
        this.price = product.price;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // methods to faciliate DTO
    public void fromDAO(final ProductDAO dao) {

        this.id = dao.getProduct_id()+"";
        this.name = dao.getProduct_name();
        this.category = dao.getCategory();
        this.description = dao.getDetails();
        this.price = dao.getPrice();

    }

    public ProductDAO toDAO() {
        ProductDAO dao = new ProductDAO();
        dao.setProduct_id(Integer.parseInt(this.id));
        dao.setProduct_name(this.name);
        dao.setDetails(this.category);
        dao.setPrice(this.price);

        return dao;
    }

    public Product(final ProductDAO dao){
        this.fromDAO(dao);
    }

   // methods to faciliate debugging

    @Override
    public String toString() {
        return "Product [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
                + ", price=" + price + "]";
    }


}
