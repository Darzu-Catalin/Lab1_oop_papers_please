package oop.practice;

public enum Planets {
    Earth,
    Asgard,
    Betelgeuse,
    Vogsphere,
    Kashyyyk,
    Endor,
    UNKNOWN;

    public String toString(){
        switch(this){
            case Earth :
                return "Earth";
            case Asgard :
                return "Asgard";
            case Betelgeuse :
                return "Betelgeuse";
            case Vogsphere:
                return "Vogsphere";
            case Kashyyyk:
                return "Kashyyyk";
            case Endor:
                return "Endor";
            case UNKNOWN:
                return "UNKNOWN";

        }
        return null;
    }
}
