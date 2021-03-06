/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package positions;

import java.util.ArrayList;

import simulation.Team;

public class PlayerK extends Player {

    //KickPow affects how far he can kick
    public int ratKickPow;
    //KickAcc affects how accurate his kicks are
    public int ratKickAcc;
    //KickFum affects how often he can fumble the snap
    public int ratKickFum;
    public int ratPressure;

    //Stats
    public int statsXPAtt;
    public int statsXPMade;
    public int statsFGAtt;
    public int statsFGMade;

    public int careerXPAtt;
    public int careerXPMade;
    public int careerFGAtt;
    public int careerFGMade;

    //Size Config
    private final int hAvg = 69;
    private final int hMax = 4;
    private final int hMin = -5;
    private final int wAvg = 150;
    private final int wMax = 35;
    private final int wMin = 15;

    public PlayerK(Team t, String nm, int yr, int reg, int trait, int iq, int scout, boolean transfer, boolean wasRS, int pot, int dur, boolean rs, int pow, int acc, int fum, int prs, int h, int w) {
        position = "K";
        team = t;
        name = nm;
        year = yr;

        ratPot = pot;
        ratFootIQ = iq;
        ratDur = dur;
        ratKickPow = pow;
        ratKickAcc = acc;
        ratKickFum = fum;
        ratPressure = prs;
        isRedshirt = rs;
        wasRedshirt = wasRS;

        homeState = reg;
        personality = trait;
        recruitRating = scout;
        height = h;
        weight = w;
        ratOvr = getOverall();

        resetSeasonStats();
        resetCareerStats();
    }

    public PlayerK(Team t, String nm, int yr, int reg, int trait, int iq, int scout, boolean transfer, boolean wasRS, boolean wo, int pot, int dur, boolean rs, int cGamesPlayed, int cWins, int cHeismans, int cAA, int cAC, int cTF, int cAF,
                   int pow, int acc, int fum, int prs, int h, int w, int cXPA, int cXPM, int cFGA, int cFGM) {
        position = "K";
        team = t;
        name = nm;
        year = yr;

        ratPot = pot;
        ratFootIQ = iq;
        ratDur = dur;
        ratKickPow = pow;
        ratKickAcc = acc;
        ratKickFum = fum;
        ratPressure = prs;
        isRedshirt = rs;
        wasRedshirt = wasRS;

        isTransfer = transfer;
        isWalkOn = wo;
        homeState = reg;
        personality = trait;
        recruitRating = scout;
        height = h;
        weight = w;
        ratOvr = getOverall();

        resetSeasonStats();

        careerXPAtt = cXPA;
        careerXPMade = cXPM;
        careerFGAtt = cFGA;
        careerFGMade = cFGM;
        careerGames = cGamesPlayed;
        careerHeismans = cHeismans;
        careerAllAmerican = cAA;
        careerAllConference = cAC;
        careerTopFreshman = cTF;
        careerAllFreshman = cAF;
        careerWins = cWins;
    }

    public PlayerK(Team t, String nm, int yr, int reg, int trait, int iq, int scout, boolean transfer, boolean wasRS, boolean wo, int pot, int dur, boolean rs, int cGamesPlayed, int cWins, int cHeismans, int cAA, int cAC, int cTF, int cAF,
                   int pow, int acc, int fum, int prs, int h, int w, int cXPA, int cXPM, int cFGA, int cFGM,
                   int seaXPAtt, int seaXPMade, int seaFGAtt, int seaFGMade,
                   int seaGames, int seaGPlayed, int seaWins, boolean inj, boolean medRS, int tt, int ratImp, boolean wonHeis, boolean wonAA, boolean wonAC, boolean wonTF, boolean wonAF) {
        position = "K";
        team = t;
        name = nm;
        year = yr;

        ratPot = pot;
        ratFootIQ = iq;
        ratDur = dur;
        ratKickPow = pow;
        ratKickAcc = acc;
        ratKickFum = fum;
        ratPressure = prs;
        isRedshirt = rs;
        wasRedshirt = wasRS;

        isTransfer = transfer;
        isWalkOn = wo;
        homeState = reg;
        personality = trait;
        recruitRating = scout;
        height = h;
        weight = w;
        ratOvr = getOverall();

        resetSeasonStats();

        careerXPAtt = cXPA;
        careerXPMade = cXPM;
        careerFGAtt = cFGA;
        careerFGMade = cFGM;
        careerGames = cGamesPlayed;
        careerHeismans = cHeismans;
        careerAllAmerican = cAA;
        careerAllConference = cAC;
        careerTopFreshman = cTF;
        careerAllFreshman = cAF;
        careerWins = cWins;

        statsXPAtt = seaXPAtt;
        statsXPMade = seaXPMade;
        statsFGAtt = seaFGAtt;
        statsFGMade = seaFGMade;

        gamesStarted = seaGames;
        gamesPlayed = seaGPlayed;
        statsWins = seaWins;

        isInjured = inj;
        isMedicalRS = medRS;
        troubledTimes = tt;
        ratImprovement = ratImp;

        wonHeisman = wonHeis;
        wonAllAmerican = wonAA;
        wonAllConference = wonAC;
        wonTopFreshman = wonTF;
        wonAllFreshman = wonAF;
    }



    public PlayerK(String nm, int yr, int stars, Team t) {
        position = "K";
        height = hAvg + (int) (Math.random() * ((hMax - hMin) + 1)) + hMin;
        weight = wAvg + (int) (Math.random() * ((wMax - wMin) + 1)) + wMin;
        name = nm;
        year = yr;
        team = t;

        wasRedshirt = getWasRedshirtStatus();

        createGenericAttributes();

        ratKickPow = (int) (ratBase + year * yearFactor + stars * starFactor - ratTolerance * Math.random());
        ratKickAcc = (int) (ratBase + year * yearFactor + stars * starFactor - ratTolerance * Math.random());
        ratKickFum = (int) (ratBase + year * yearFactor + stars * starFactor - ratTolerance * Math.random());
        ratPressure = (int) (ratBase + year * yearFactor + stars * starFactor - ratTolerance * Math.random());
        ratOvr = getOverall();

        recruitRating = getScoutingGrade();

        recruitTolerance = (int) ((60 - team.teamPrestige) / kImportance);
        cost = getInitialCost();
        cost = (int) (cost / kImportance);
        cost = getLocationCost();
        if (cost < 0) cost = (int) Math.random() * 5 + 1;

        resetSeasonStats();
        resetCareerStats();
    }

    public PlayerK(String nm, int yr, int stars, Team t, boolean custom) {
        position = "K";
        height = hAvg + (int) (Math.random() * ((hMax - hMin) + 1)) + hMin;
        weight = wAvg + (int) (Math.random() * ((wMax - wMin) + 1)) + wMin;
        name = nm;
        year = yr;
        team = t;

        wasRedshirt = getWasRedshirtStatus();

        createGenericAttributes();

        ratKickPow = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratKickAcc = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratKickFum = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratPressure = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratOvr = getOverall();

        if (custom) isWalkOn = true;
        recruitRating = getScoutingGrade();

        resetSeasonStats();
        resetCareerStats();
    }

    public void midSeasonProgression() {
        final int ratOvrStart = ratOvr;
        progression = getProgression();
        double games = getMidSeasonBonus();

        ratFootIQ += (int) (Math.random() * games);
        ratKickPow += (int) (Math.random() * games);
        ratKickAcc += (int) (Math.random() * games);
        ratKickFum += (int) (Math.random() * games);
        ratPressure += (int) (Math.random() * games);

        ratOvr = getOverall();
        ratImprovement = ratOvr - ratOvrStart;
    }


    @Override
    public void advanceSeason() {
        double games = getGamesBonus();

        if (!isMedicalRS) {
            if (wonAllConference) ratPot += (int) Math.random() * allConfPotBonus;
            if (wonAllAmerican) ratPot += (int) Math.random() * allAmericanBonus;
            if (wonAllFreshman) ratPot += (int) Math.random() * allFreshmanBonus;
            if (wonTopFreshman) ratPot += (int) Math.random() * topBonus;
            if (wonHeisman) ratPot += (int) Math.random() * topBonus;
            progression = getProgression();

            if (year > 2 && games < minGamesPot) ratPot -= (int) (Math.random() * 15);

            ratFootIQ += (int) (Math.random() * (progression + games - endseason)) / endseasonFactor;
            ratKickPow += (int) (Math.random() * (progression + games - endseason)) / endseasonFactor;
            ratKickAcc += (int) (Math.random() * (progression + games - endseason)) / endseasonFactor;
            ratKickFum += (int) (Math.random() * (progression + games - endseason)) / endseasonFactor;
            ratPressure += (int) (Math.random() * (progression + games - endseason)) / endseasonFactor;

            if (Math.random() * 100 < progression) {
                //breakthrough
                ratKickPow += (int) (Math.random() * (progression + games - endseasonBonus)) / endseasonFactor;
                ratKickAcc += (int) (Math.random() * (progression + games - endseasonBonus)) / endseasonFactor;
                ratKickFum += (int) (Math.random() * (progression + games - endseasonBonus)) / endseasonFactor;
                ratPressure += (int) (Math.random() * (progression + games - endseasonBonus)) / endseasonFactor;
            }

            durabilityProgression();
        }

        ratOvr = getOverall();
        ratImprovement = ratOvr - ratOvrStart;
        //reset stats (keep career stats?)
        careerXPAtt += statsXPAtt;
        careerXPMade += statsXPMade;
        careerFGAtt += statsFGAtt;
        careerFGMade += statsFGMade;
        careerGames += gamesPlayed;
        careerWins += statsWins;

        addSeasonAwards();
        checkRedshirt();
    }

    private void resetSeasonStats() {
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        troubledTimes = 0;

        statsXPAtt = 0;
        statsXPMade = 0;
        statsFGAtt = 0;
        statsFGMade = 0;
        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        wonAllFreshman = false;
        wonTopFreshman = false;
        statsWins = 0;
    }

    private void resetCareerStats() {
        careerXPAtt = 0;
        careerXPMade = 0;
        careerFGAtt = 0;
        careerFGMade = 0;
        careerGames = 0;
        careerHeismans = 0;
        careerAllAmerican = 0;
        careerAllConference = 0;
        careerAllFreshman = 0;
        careerTopFreshman = 0;
        careerWins = 0;
    }

    @Override
    public int getHeismanScore() {
        return (statsFGMade * 20 + statsXPMade * 5) * (int) getFGpct() / 100 + ratOvr * 10;
    }

    @Override
    public int getCareerScore() {
        return (statsFGMade * 20 + statsXPMade * 5) * (int) getFGpct() / 100 + ratOvr * 10 + (careerFGMade * 25 + careerXPMade * 5) * (int) (getCareerFGpct() / 100) + ratOvr * 10 * year;
    }

    public float getFGpct() {
        if (statsFGAtt < 1) {
            return 0;
        } else {

            float rating = 100 * (float) statsFGMade / (statsFGAtt);
            return rating;
        }
    }

    private float getCareerFGpct() {
        if (statsFGAtt + careerFGAtt < 1) {
            return 0;
        } else {

            float rating = (float) 100 * (statsFGMade + careerFGMade) / (statsFGAtt + careerFGAtt);
            return rating;
        }
    }


    @Override
    public ArrayList<String> getDetailAllStatsList() {
        ArrayList<String> pStats = stringPlayerInfo();
        pStats.add(" > ");
        pStats.add("[B]PLAYER RATINGS");
        ArrayList<String> attributes = stringPlayerAttributes();
        for(String a : attributes) {
            pStats.add(a);
        }
        pStats.add("Kick Strength: " + getLetterGrade(ratKickPow) + ">Kick Accuracy: " + getLetterGrade(ratKickAcc));
        pStats.add("Clumsiness: " + getLetterGrade(ratKickFum) + ">Pressure: " + getLetterGrade(ratPressure));
        pStats.add(" > ");
        pStats.add("[B]SEASON STATS");


        if (statsXPAtt > 0) {
            pStats.add("XP Made/Att: " + statsXPMade + "/" + statsXPAtt + ">XP Percent: " + df2.format(100 * (float) statsXPMade / (statsXPAtt)) + "%");
        } else {
            pStats.add("XP Made/Att: 0/0>XP Percent: 0%");
        }

        if (statsFGAtt > 0) {
            pStats.add("FG Made/Att: " + statsFGMade + "/" + statsFGAtt + ">FG Percent: " + df2.format(getFGpct()) + "%");
        } else {
            pStats.add("FG Made/Att: 0/0>FG Percent: 0%");
        }
        pStats.add("Games: " + gamesPlayed + " (" + statsWins + "-" + (gamesStarted - statsWins) + ")" + "> ");

        pStats.add(" > ");
        pStats.add("[B]CAREER STATS");
        pStats.addAll(getCareerStatsList());
        return pStats;
    }

    @Override
    public ArrayList<String> getCareerStatsList() {
        ArrayList<String> pStats = new ArrayList<>();
        if ((statsXPAtt + careerXPAtt) > 0) {
            pStats.add("XP Made/Att: " + (statsXPMade + careerXPMade) + "/" + (statsXPAtt + careerXPAtt) +
                    ">XP Percentage: " +df2.format (100 * (float) (statsXPMade + careerXPMade) / (statsXPAtt + careerXPAtt)) + "%");
        } else {
            pStats.add("XP Made/Att: 0/0>XP Percentage: 0%");
        }

        if ((statsFGAtt + careerFGAtt) > 0) {
            pStats.add("FG Made/Att: " + (statsFGMade + careerFGMade) + "/" + (statsFGAtt + careerFGAtt) +
                    ">FG Percentage: " + df2.format(getCareerFGpct()) + "%");
        } else {
            pStats.add("FG Made/Att: 0/0>FG Percentage: 0%");
        }
        pStats.addAll(super.getCareerStatsList());
        return pStats;
    }

    @Override
    public String getInfoForLineup() {
        if (injury != null)
            return getInitialName() + " [" + getYrStr() + "] " + ratOvr + "/" + getPotRating(team.HC.get(0).ratTalent) + " " + injury.toString();
        return getInitialName() + " [" + getYrStr() + "] " + ratOvr + "/" + getPotRating(team.HC.get(0).ratTalent) + " (" +
                getLetterGrade(ratKickPow) + ", " + getLetterGrade(ratKickAcc) + ", " + getLetterGrade(ratKickFum) + ", " + getLetterGrade(ratPressure) + ")";
    }

    public int getOverall() {
        int ovr;
        ovr = (ratKickPow + ratKickAcc + ratPressure) / 3;
        return ovr;
    }
}
