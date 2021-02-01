package com.company.utils;

//Class for calculating gained xp and setting target xp
public class Level {
    //heroes starts at level 1 with xp 0, and 100xp as the target.
    public int level = 1;
    public int xp = 0;
    public int targetXp = 100;

    //Updates the attributes, and sets the target xp for the next level.
    //Returns amounts of levels
    public int gainXp(int gainxp) {
        int counter = 0;

        while (gainxp != 0) {
            int remainingXp = targetXp - xp;

            if (remainingXp == gainxp) {
                updateLvl();
                counter++;
            }
            if (remainingXp > gainxp) {
                xp = gainxp;
                gainxp = 0;
            }
            if (remainingXp < gainxp) {
                xp = remainingXp;
                updateLvl();
                gainxp = gainxp - remainingXp;
                counter++;
            }
        }
        return counter;
    }

    /**
     * to update the level, reset xp and set a new targetxp
     */
    private void updateLvl() {
        level++;
        xp = 0;
        targetXp = (int) (targetXp * 1.1);


    }

}
