package model;

import statistics.DataForGraphs;
import statistics.PlayerMatchStatistics;
import statistics.PlayerStatistics;

import java.util.Stack;

public class ModelCancel {

    static private Stack<Integer> codeOfOperation = new Stack<>();
    static private Stack<PlayerMatchStatistics[]> playerMatchStatisticsStack = new Stack<>();
    static private Stack<PlayerStatistics> playerStatisticsStack = new Stack<>();
    static private Stack<DataForGraphs> dataForGraphsStack = new Stack<>();


    public static Stack<Integer> getCodeOfOperation() {
        return codeOfOperation;
    }

    public static void setCodeOfOperation(Integer code) {
        ModelCancel.codeOfOperation.push(code);
    }

    public static Stack<PlayerMatchStatistics[]> getPlayerMatchStatisticsStack() {
        return playerMatchStatisticsStack;
    }

    public  static void setPlayerMatchStatisticsStack(PlayerMatchStatistics[] playerMatchStatisticsStack) {
        ModelCancel.playerMatchStatisticsStack.push(playerMatchStatisticsStack);
    }

    public static Stack<PlayerStatistics> getPlayerStatisticsStack() {
        return playerStatisticsStack;
    }

    public static void setPlayerStatisticsStack(PlayerStatistics playerStatisticsStack) {
        ModelCancel.playerStatisticsStack.push(playerStatisticsStack);
    }

    public static Stack<DataForGraphs> getDataForGraphsStack() {
        return dataForGraphsStack;
    }

    public static void setDataForGraphsStack(DataForGraphs dataForGraphsStack) {
        ModelCancel.dataForGraphsStack.push(dataForGraphsStack);
    }
}
