/*
 * Copyright (c) 2021 |  Rían Errity. GPLv3
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 3 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Rían Errity <rian@paradaux.io> or visit https://paradaux.io
 * if you need additional information or have any questions.
 * See LICENSE.md for more details.
 */

package io.paradaux.friendlybot.utils.embeds.notices;

import io.paradaux.friendlybot.utils.models.enums.EmbedColour;
import io.paradaux.friendlybot.utils.models.interfaces.Embed;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class ModMailNoticeEmbed implements Embed {

    final EmbedBuilder builder = new EmbedBuilder();

    public ModMailNoticeEmbed() {
        builder.setAuthor("The Computer Science Friendly Discord.");
        builder.setColor(EmbedColour.INFO.getColour());

        builder.addField("Mod Mail System", "If you are having issues with verification, with"
                + " another user or have any general questions, please let us know!" + "\n\nIf"
                + " you send a message into this channel, it will be automatically deleted and "
                + "forwarded to the moderators. Your inquiry " + "will be logged and a copy of "
                + "the message you sent as well as an automatically assigned ticket number will be"
                + " sent to you via DMs.", false);

        builder.setFooter("Computer Science Friendly Bot | v0.1");
    }

    @Override
    public void sendEmbed(TextChannel channel) {
        channel.sendMessage(builder.build()).queue();
    }
    public EmbedBuilder getBuilder() { return builder; }

}