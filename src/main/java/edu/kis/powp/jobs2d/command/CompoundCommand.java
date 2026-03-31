package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * Concrete implementation of ICompoundCommand.
 * Executes multiple commands in sequence and provides iteration over them.
 */
public class CompoundCommand implements ICompoundCommand {

	private List<DriverCommand> commands;

	/**
	 * Creates an empty compound command.
	 */
	public CompoundCommand() {
		this.commands = new ArrayList<>();
	}

	/**
	 * Creates a compound command with initial commands.
	 *
	 * @param commands initial list of commands
	 */
	public CompoundCommand(List<DriverCommand> commands) {
		this.commands = new ArrayList<>(commands);
	}

	/**
	 * Add a command to the compound command.
	 *
	 * @param command the command to add
	 */
	public void addCommand(DriverCommand command) {
		commands.add(command);
	}

	/**
	 * Remove a command from the compound command.
	 *
	 * @param command the command to remove
	 * @return true if command was removed, false otherwise
	 */
	public boolean removeCommand(DriverCommand command) {
		return commands.remove(command);
	}

	/**
	 * Clear all commands from the compound command.
	 */
	public void clearCommands() {
		commands.clear();
	}

	/**
	 * Get the number of commands in this compound command.
	 *
	 * @return number of commands
	 */
	public int getCommandCount() {
		return commands.size();
	}

	/**
	 * Execute all commands in sequence on the given driver.
	 *
	 * @param driver the driver to execute commands on
	 */
	@Override
	public void execute(Job2dDriver driver) {
		for (DriverCommand command : commands) {
			command.execute(driver);
		}
	}

	/**
	 * Get iterator over commands.
	 *
	 * @return iterator over commands
	 */
	@Override
	public Iterator<DriverCommand> iterator() {
		return commands.iterator();
	}

	@Override
	public String toString() {
		return "CompoundCommand [" + commands.size() + " commands]";
	}
}
