/*
 * MIT License
 *
 * Copyright (c) 2021 Rían Errity
 * io.paradaux.friendlybot.commands.fun.PingCommand :  31/01/2021, 01:28
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.paradaux.friendlybot.commands.fun;

import com.jagrosh.jdautilities.command.CommandEvent;
import io.paradaux.friendlybot.FriendlyBot;
import io.paradaux.friendlybot.utils.models.types.BaseCommand;
import org.slf4j.Logger;

/**
 * Ping Command is used to gauge DiscordAPI Latency.
 *
 * @author Rían Errity
 * @version Last Modified for 0.1.0-SNAPSHOT
 * @since 2/11/2020 DD/MM/YY
 * @see FriendlyBot
 * */


public class PingCommand extends BaseCommand {

    public PingCommand(Logger logger) {
        super(logger);
        this.name = "ping";
        this.help = "Latency Test Command.";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.getChannel().sendMessage("Pong!").queue();
    }
}
