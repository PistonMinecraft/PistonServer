package org.pistonmc.api.plugin;

import net.kyori.adventure.audience.Audience;

/**
 * Represents something that could
 * execute commands and receive messages
 */
public interface CommandSource extends Audience {
    /**
     * A NULL CommandSource does nothing
     */
    CommandSource NULL = new CommandSource() {
        public boolean acceptsSuccess() { return false; }
        public boolean acceptsFailure() { return false; }
        public boolean shouldInformAdmins() { return false; }
    };

    /**
     * Gets whether to send the success output of the command to this {@link CommandSource}
     * @return if send the success output of the command to this {@link CommandSource}
     */
    boolean acceptsSuccess();

    /**
     * Gets whether to send the fail output of the command to this {@link CommandSource}
     * @return if should send the fail output of the command to this {@link CommandSource}
     */
    boolean acceptsFailure();

    /**
     * Gets whether to inform the success output of the command to admins
     * @return if should inform the success output of the command to admins
     */
    boolean shouldInformAdmins();
}