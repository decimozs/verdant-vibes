package constants;

public class Plant {
	private String name;
	private String category;
	private String family;
	private String price;
	private String image;
	private String description;
	
	public Plant(String name, String category, String family, String price, String image, String description) {
		this.name = name;
		this.category = category;
		this.family = family;
		this.price = price;
		this.image = image;
		this.description = description;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}