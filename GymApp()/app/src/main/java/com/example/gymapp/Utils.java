package com.example.gymapp;

import android.util.Log;

import java.util.ArrayList;

public class Utils {

    private static final String TAG = "Utils";

    private static ArrayList<GymTraining> allTrainings;
private static ArrayList<Plan>usersPlans;


    public Utils () {

    }


public static void initializeAll(){
            Log.d(TAG, "Utils: called");

            if(null==usersPlans){
                usersPlans=new ArrayList<>();
            }

if(null==allTrainings)allTrainings=new ArrayList<>();


GymTraining squat = new GymTraining();
squat.setName("Squat");
squat.setShortDesc("Sit down and sit up :)");
squat.setLongDesc(" Position yourself close to the ground balancing on the front part of your feet with your legs bent under your body");
squat.setImageUrl("https://lmimirror3pvr.azureedge.net/static/media/16949/921e38e6-9020-4dd9-a619-7726cadc7284/fit-planet-60-hero-image-960x540.jpg");
allTrainings.add(squat);

    GymTraining pushUp = new GymTraining();
    pushUp.setName("Push Up");
    pushUp.setShortDesc(" Raising and lowering your body");
    pushUp.setLongDesc("Common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids, serratus anterior, coracobrachialis and the midsection as a whole. Push-ups are a basic exercise used in civilian athletic training or physical education and commonly in military physical training");
    pushUp.setImageUrl("https://upl.stack.com/wp-content/uploads/Quickly-Strengthen-Your-Upper-Body-With-Pyramid-Push-Ups.jpg");
    allTrainings.add(pushUp);

    GymTraining chestFly = new GymTraining();
    chestFly.setName("Chest Fly");
    chestFly.setShortDesc("Kinda Push Ups with dumbbel");
    chestFly.setLongDesc("Chest Fly is a great upper body move that uses dumbbells to strengthen the muscles of the chest and arms in a different and complementary way to push-ups");
    chestFly.setImageUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/form-check-10-1554408283.png");
    allTrainings.add(chestFly);

    GymTraining legPress = new GymTraining();
    legPress.setName("Leg Press");
    legPress.setShortDesc("Machine exercise targeting the quadriceps");
    legPress.setLongDesc("The leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs. The term leg press also refers to the apparatus used to perform this exercise. The leg press can be used to evaluate an athlete's overall lower body strength");
    legPress.setImageUrl("https://fitlineequipment.com/wp-content/uploads/2019/05/Precor-DPL0601-Angled-Leg-Press-4.jpg");
    allTrainings.add(legPress);



    }

    public static String getTAG() {
        return TAG;
    }

    public static ArrayList<GymTraining> getAllTrainings() {
        return allTrainings;
    }

    public static void setAllTrainings(ArrayList<GymTraining> allTrainings) {
        Utils.allTrainings = allTrainings;
    }

    public static ArrayList<Plan> getUsersPlans() {
        return usersPlans;
    }

    public static void setUsersPlans(ArrayList<Plan> usersPlans) {
        Utils.usersPlans = usersPlans;
    }

    public static boolean addToUsersPlan (Plan plan){

        Log.d(TAG, "addToUsersPlan: started");
        return usersPlans.add(plan);
    }

    public static boolean removeUsersPlan(Plan plan){

        Log.d(TAG, "removeUsersPlan: started");
        return usersPlans.remove(plan);
    }

}
