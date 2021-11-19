package models;

public class Medicine {
    private int id;
    private String name;
    private String expirationDate;
    private String activeIngredient;
    private int amount;

    public Medicine(int id, String name, String expirationDate, String activeIngredient, int amount) {
        setId(id);
        this.setName(name);
        this.setExpirationDate(expirationDate);
        this.setActiveIngredient(activeIngredient);
        this.setAmount(amount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
