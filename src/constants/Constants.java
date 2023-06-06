package constants;

public class Constants {
    private static final String BASEPATH = "/resources/";
    private static final String ITEM_IMAGE = "ItemImage/";
    private static final String DESCRIPTION_IMAGE = "DescriptionImage/";
	
    public Hydrangea createHydrangea(){
        return new Hydrangea(
                "Hydrangea",
                "Shrubs",
                "Hydrangeaceae",
                "₱ 900.00",
                BASEPATH + "hydrangeaItemImage.png",
                BASEPATH + DESCRIPTION_IMAGE + "hydrangeaDescription.png"   
	    );
    }

    public Forsythia createForsythia(){
        return new Forsythia(
            "Forsythia",
            "Shrubs",
            "Olives",
            "₱ 900.00",
            BASEPATH + ITEM_IMAGE + "forsythiaItemImage.png",
            BASEPATH + DESCRIPTION_IMAGE + "forsythiaDescription.png"
        );
    }

    public Sage createSage(){
        return new Sage(
            "Sage",
	    	"Herbs",
	    	"Mints",
	    	"₱ 700.00",
	    	BASEPATH + "sageDescriptionImage.png",
	    	BASEPATH + DESCRIPTION_IMAGE + "sageDescription.png" 
        );
    }

    public Rosemary createRosemary(){
        return new Rosemary(
            "Rosemary",
            "Herbs",
            "Mints",
            "₱ 900.00",
            BASEPATH + ITEM_IMAGE + "rosemaryItemImage.png",
            BASEPATH + DESCRIPTION_IMAGE + "rosemaryDescription.png"
        );
    }

    public DevilsIvy createDevilsIvy(){
        return new DevilsIvy(
            "Devil's ivy",
	    	"Creepers",
	    	"Arums",
	    	"₱ 1000.00",
	    	BASEPATH + ITEM_IMAGE + "devilsivyItemImage.png",
	    	BASEPATH + DESCRIPTION_IMAGE + "devilsivyDescription.png"
        );
    }

    public EnglishIvy createEnglishIvy(){
        return new EnglishIvy(
            "English ivy",
	    	"Creepers",
	    	"Araliaceae",
	    	"₱ 1000.00",
	    	BASEPATH + ITEM_IMAGE + "englishivyItemImage.png",
	    	BASEPATH + DESCRIPTION_IMAGE + "englishivyDescription.png"
        );
    }

    public Wisteria createWisteria(){
        return new Wisteria(
            "Wisteria",
	    	"Climbers",
	    	"Fabaceae",
	    	"₱ 1500.00",
	    	BASEPATH + ITEM_IMAGE + "wisteriaItemImage.png",
	    	BASEPATH + DESCRIPTION_IMAGE + "wisteriaDescription.png"
        );
    }

    public StarJasmine createStarJasmine(){
        return new StarJasmine(
            "Star Jasmine",
	    	"Climbers",
	    	"Apocynaceae",
	    	"₱ 1400.00",
	    	BASEPATH + ITEM_IMAGE + "startjasmineItemImage.png",
	    	BASEPATH + DESCRIPTION_IMAGE + "starjasmineDescription.png"
        );
    }

    public Pine createPine(){
        return new Pine(
            "Pine",
	    	"Trees",
	    	"Pinaceae",
	    	"₱ 1300.00",
	    	BASEPATH + ITEM_IMAGE + "pineItemImage.png",
	    	BASEPATH + DESCRIPTION_IMAGE + "pineDescription.png"
        );
    }

    public Conifers createConifers(){
        return new Conifers(
            "Conifers",
	    	"Trees",
	    	"Pinaceae",
	    	"₱ 1300.00",
	    	BASEPATH + ITEM_IMAGE + "conifersItemImage.png",
	    	BASEPATH + DESCRIPTION_IMAGE + "cornifersDescription.png"
        );
    }
}
