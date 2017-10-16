/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.controler.impl;

import java.util.Collection;

import fr.xebia.mow.model.IPositionnedObject;
import fr.xebia.mow.model.controler.ICommand;
import fr.xebia.mow.model.controler.IRule;

/**
 * This class implements a rule to avoid any kind of specified {@link IPositionnedObject}.
 *
 * @param <C>
 *            Any type extending {@link ICommand} on which the present rule is to be applied
 * @param <O>
 *            Any type extending {@link IPositionnedObject} to be avoided if present among the given objects
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class AvoidType<C extends ICommand, O extends IPositionnedObject> implements IRule {

    private final Class<C> commandClazz;
    private final Class<O> objectClazz;

    /**
     * Create an avoid type rule that applies only to the given class command.
     *
     * @param commandClazz
     *            positionned object class to avoid
     * @param objectClazz
     *            positionned object class to avoid
     */
    public AvoidType(final Class<C> commandClazz, final Class<O> objectClazz) {
        this.commandClazz = commandClazz;
        this.objectClazz = objectClazz;
    }

    /**
     * Create an avoid type rule that applies to any command.
     *
     * @param objectClazz
     *            positionned object class to avoid
     */
    public AvoidType(final Class<O> objectClazz) {
        this(null, objectClazz);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.IRule#allow(java.util.Collection)
     */
    @Override
    public boolean allow(final Collection<IPositionnedObject> objects) {
        for (final IPositionnedObject object : objects) {
            if (this.objectClazz.isInstance(object)) {
                return false;
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.IRule#applyTo(fr.xebia.mow.controler.ICommand)
     */
    @Override
    public boolean applyTo(final ICommand command) {
        return this.commandClazz == null || this.commandClazz.isAssignableFrom(command.getClass());
    }

}
