/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.controler;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;

/**
 * The Class MowControler.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class MowControler {

    private final IMow           mow;
    private final IMap           map;
    private final Set<IRule>     rules    = new HashSet<>();
    private final List<ICommand> commands = new LinkedList<>();

    /**
     * Instantiates a new mow controler.
     *
     * @param mow
     *            the mow
     * @param map
     *            the map
     */
    public MowControler(final IMow mow, final IMap map) {
        super();
        this.mow = mow;
        this.map = map;
        // TODO ensure validity betwwen mow position and map borders
    }

    /**
     * Instantiates a new mow controler with a predefined collection of commands.
     *
     * @param mow
     *            the mow
     * @param map
     *            the map
     * @param commands
     *            the commands
     */
    public MowControler(final IMow mow, final IMap map, final Collection<ICommand> commands) {
        this(mow, map);
        this.commands.addAll(commands);
    }

    /**
     * Adds the command.
     *
     * @param command
     *            the command
     */
    public void addCommand(final ICommand command) {
        this.commands.add(command);
    }

    /**
     * Adds the rule.
     *
     * @param rule
     *            the rule
     */
    public void addRule(final IRule rule) {
        this.rules.add(rule);
    }

    /**
     * Display.
     */
    public void display() {
        System.out.println(this.mow);

    }

    /**
     * Run.
     */
    public void run() {
        for (final ICommand command : this.commands) {
            command.execute(this.mow, this.map, this.rules);
        }
    }

}
