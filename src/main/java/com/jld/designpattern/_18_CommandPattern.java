package com.jld.designpattern;

public class _18_CommandPattern {
    public interface Command {
        void execute();
    }

    public static class LightOnCommand implements Command {
        LightReceiver light;

        public LightOnCommand(LightReceiver light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.on();
        }
    }


    public static class LightOffCommand implements Command {
        LightReceiver light;

        public LightOffCommand(LightReceiver light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.off();
        }
    }

    public static class LightReceiver {

        public void on() {
            System.out.println("Light is on!");
        }

        public void off() {
            System.out.println("Light is off!");
        }
    }

    /**
     * 遥控器
     */
    public static class Invoker {
        private Command[] onCommands;
        private Command[] offCommands;
        private final int slotNum = 7;

        public Invoker() {
            this.onCommands = new Command[slotNum];
            this.offCommands = new Command[slotNum];
        }

        public void setOnCommand(Command command, int slot) {
            onCommands[slot] = command;
        }

        public void setOffCommand(Command command, int slot) {
            offCommands[slot] = command;
        }

        public void onButtonWasPushed(int slot) {
            onCommands[slot].execute();
        }

        public void offButtonWasPushed(int slot) {
            offCommands[slot].execute();
        }
    }

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        LightReceiver light = new LightReceiver();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        invoker.setOnCommand(lightOnCommand, 0);
        invoker.setOffCommand(lightOffCommand, 0);
        invoker.onButtonWasPushed(0);
        invoker.offButtonWasPushed(0);
    }
    //java.lang.Runnable

}
