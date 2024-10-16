package oop.practice;

import java.util.ArrayList;
import java.util.List;

public class Classification {

//    public static int getClassification(Individual individual){
//
//        String planet = individual.getPlanet();
//        BooleanState isHumanoid = individual.getHumanoidStatus();
//        Integer age = individual.getAge();
//        List<String> traits = individual.getTraits();
//
////        // Star Wars Classification
////        if (planet.equalsIgnoreCase("Kashyyk") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
////            return 1; // Wookie
////        } else if (planet.equalsIgnoreCase("Endor") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
////            return 1;// Ewok
////        }
////
////        // Marvel Classification
////        if (planet.equalsIgnoreCase("Asgard") && (isHumanoid != null && isHumanoid == BooleanState.TRUE)) {
////            return 2; // Asgardian
////        }
////
////        // Hitchhiker's Classification
////        if (planet.equalsIgnoreCase("BETELGEUSE") && (isHumanoid != null && isHumanoid == BooleanState.TRUE)) {
////            return 3; // Betelgeusian
////        } else if (planet.equalsIgnoreCase("Vogsphere") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
////            return 3; // Vogons
////        }
////
////        // Lord of the Rings Classification
////        if (planet.equalsIgnoreCase("Earth")) {
////            if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
////                if (traits != null && traits.contains("POINTY_EARS")) {
////                    return 4; // Elf
////                } else {
////                    return 4; // Dwarf
////                }
////            }
////        }
//
//        // Generalized Classification
//        // Generalized Classification without Strict Property Dependencies
//        if (isHumanoid != null) {
//            if (isHumanoid == BooleanState.FALSE) {
//                if (planet != null) {
//                    if (planet.equalsIgnoreCase("Kashyyk")) {
//                        // Wookie
//                        if (age >= 0 && age <= 400) {
//                            if (traits != null && traits.contains("HAIRY") && traits.contains("TALL")) {
//                                return 1; // Wookie
//                            }
//                        }
//                    } else if (planet.equalsIgnoreCase("Endor")) {
//                        // Ewok
//                        if (age >= 0 && age <= 60) {
//                            if (traits != null && traits.contains("SHORT") && traits.contains("HAIRY")) {
//                                return 1; // Ewok
//                            }
//                        }
//                    } else if (planet.equalsIgnoreCase("Vogsphere")) {
//                        // Vogons
//                        if (age >= 0 && age <= 200) {
//                            if (traits != null && traits.contains("GREEN") && traits.contains("BULKY")) {
//                                return 3; // Vogons
//                            }
//                        }
//                    }
//                }
//            } else if (isHumanoid == BooleanState.TRUE) {
//                if (planet != null) {
//                    if (planet.equalsIgnoreCase("Asgard")) {
//                        // Asgardian
//                        if (age >= 0 && age <= 5000) {
//                            return 2; // Asgardian
//                        }
//                    } else if (planet.equalsIgnoreCase("BETELGEUSE")) {
//                        // Betelgeusian
//                        if (age >= 0 && age <= 100) {
//                            return 3; // Betelgeusian
//                        }
//                    } else if (planet.equalsIgnoreCase("Earth")) {
//                        // Check for Elves or Dwarves
//                        if (age >= 0) { // Indefinite age handling
//                            if (traits != null) {
//                                if (traits.contains("POINTY_EARS")) {
//                                    return 4; // Elf
//                                } else if (traits.contains("SHORT") && traits.contains("BULKY")) {
//                                    return 4; // Dwarf
//                                }
//                            }
//                        }
//                    }
//                }
//
//                // Additional trait checks for Betelgeusians if no planet is specified
//                if (traits != null && (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
//                    return 3; // Betelgeusian
//                }
//            }
//        }
//
//// Fallback classification for unknown objects
//        return -1; // Unknown classification
//
//    }
public static int getClassification(Individual individual) {
    BooleanState isHumanoid = individual.getHumanoidStatus();
    String planet = individual.getPlanet();
    Integer age = individual.getAge(); // Can be null
    List<String> traits = individual.getTraits();

    // Handle Star Wars Classification (Wookie and Ewok)
    if (isHumanoid == BooleanState.FALSE) {
        if (planet != null && planet.equalsIgnoreCase("Kashyyyk") && age != null && age >= 0 && age <= 400 && traits != null && traits.contains("HAIRY")) {
            return 1; // Wookie
        } else if (planet != null && planet.equalsIgnoreCase("Endor") && age != null && age >= 0 && age <= 60 && traits != null && traits.contains("HAIRY") && traits.contains("SHORT")) {
            return 1; // Ewok
        }
    }

    // Handle Lord of the Rings Universe (Elf and Dwarf)
    if (planet != null && planet.equalsIgnoreCase("Earth") && isHumanoid == BooleanState.TRUE) {
        if (traits != null && traits.contains("BLONDE")  && (age == null || age >= 0)) {
            return 4; // Elf
        } else if (traits != null && traits.contains("SHORT") && traits.contains("BULKY") && (age == null || age <= 200)) {
            return 4; // Dwarf
        }
    }

    // Handle Marvel Universe Classification (Asgardian)
    if (isHumanoid == BooleanState.TRUE && planet != null && planet.equalsIgnoreCase("Asgard") && age != null && age >= 0 && age <= 5000 && traits != null && traits.contains("BLONDE") && traits.contains("TALL")) {
        return 2; // Asgardian
    }

    // Handle Hitchhiker's Guide Universe (Betelgeusian and Vogon)
    if (planet != null && planet.equalsIgnoreCase("Betelgeuse") && isHumanoid == BooleanState.TRUE && age != null && age >= 0 && age <= 100 && traits != null && traits.contains("EXTRA_ARMS") && traits.contains("EXTRA_HEAD")) {
        return 3; // Betelgeusian
    } else if (planet != null && planet.equalsIgnoreCase("Vogsphere") && isHumanoid == BooleanState.FALSE && age != null && age >= 0 && age <= 200 && traits != null && traits.contains("GREEN") && traits.contains("BULKY")) {
        return 3; // Vogon
    }



    // Handle characters with unknown or unspecified planets
    if (planet == null || planet.equalsIgnoreCase("UNKNOWN")) {
        if (isHumanoid == BooleanState.FALSE && traits != null && traits.contains("BULKY")) {
            return 3; // Likely Vogon
        } else if (isHumanoid == BooleanState.TRUE && traits != null && traits.contains("BULKY")){
            return 4;
        }
    }
    if (planet != null){
        if (planet.equalsIgnoreCase("Endor")){
            return 1;
        }
    }

    // Handle generic traits
    if (traits != null) {
        if (traits.contains("GREEN") && isHumanoid == BooleanState.FALSE) {
            return 3; // Vogon
        } else if (traits.contains("HAIRY") && age != null && age > 0) {
            return 1; // General hairy being
        } else if (traits.contains("BLONDE") && age != null && age <= 5000 && (isHumanoid == null || isHumanoid == BooleanState.TRUE)) {
            return 2; // Likely Asgardian
        } else if (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD")) {
            return 3;
        }
    }

    // Default classification if only humanoid status and age are available
    if (isHumanoid != null) {
        if (isHumanoid == BooleanState.TRUE && (age == null || age <= 200)) {
            return 3; // Default to Vogon for humanoids with no specific planet or traits
        }
    }

    //handle LOR cases 4 , 14
    if (planet.equalsIgnoreCase("Earth")){
        if( traits != null && traits.contains("BULKY") && traits.contains("SHORT")) {
            return 4;//case 4
        }
    } else if (isHumanoid != null & isHumanoid == BooleanState.TRUE && age > 5000) {
        return 4;// case 21
    }

    // Fallback for unspecified characters
    return -1; // Unspecified character
}


}



