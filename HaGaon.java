/*
 * Copyright (c) 2018 Daniel J. Kirsch
 * HaGaon HaMachane [https://github.com/djkirsch/HaGaonHaMachane]
 *
 * This file is part of HaGaon HaMachane.
 *
 * HaGaon HaMachane is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License
 * version 3 as published by the Free Software Foundation
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class HaGaon {
	public static void main(String[] arguments) throws Exception
	{
		EventWaiter waiter = new EventWaiter();
		CommandClientBuilder builder = new CommandClientBuilder();
		builder.setOwnerId("455504351872548885");
		builder.addCommand(new Torah());
		builder.addCommand(new Gemara());
		builder.addCommand(new Mishnah());
		builder.addCommand(new PikeriAvot());
		builder.addCommand(new Tosefta());
		builder.addCommand(new Rashi());
		builder.addCommand(new About());
		builder.addCommand(new JPS());
		builder.setPrefix("!!");
		CommandClient client = builder.build();
		Object[] EventListers = {waiter,client};
		
		String Token = "NTg4ODgzMDY1NDYwNDkwMjYw.XQ7I8A.TKn9CWl7VMvNE3h95c4_jou-Oq4";
        //String Token = "";
        try {
            JDA jda= new JDABuilder(AccountType.BOT).setToken(Token).buildAsync();
            jda.addEventListener(new BotListener());
            System.out.println("Bot connecté");
        } catch (LoginException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		/*
		
		new JDABuilder(AccountType.BOT)
		// set the token
		.setToken("NTg4ODgzMDY1NDYwNDkwMjYw.XQ7I8A.TKn9CWl7VMvNE3h95c4_jou-Oq4")

		// set the game for when the bot is loading
		.setGame(Game.playing("loading..."))

		// add the listeners
		.addEventListener(EventListers)
		// start it up!
		.buildAsync();
		*/

	}
}
