/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.avmoga.dpixel.sprites;

import com.avmoga.dpixel.Assets;
import com.avmoga.dpixel.actors.mobs.FlyingProtector;
import com.avmoga.dpixel.actors.mobs.Shaman;
import com.avmoga.dpixel.actors.mobs.Warlock;
import com.avmoga.dpixel.actors.mobs.pets.Fairy;
import com.avmoga.dpixel.actors.mobs.pets.GreenDragon;
import com.avmoga.dpixel.actors.mobs.pets.RedDragon;
import com.avmoga.dpixel.actors.mobs.pets.SugarplumFairy;
import com.avmoga.dpixel.effects.Fireball;
import com.avmoga.dpixel.effects.Lightning;
import com.avmoga.dpixel.effects.MagicMissile;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;

public class SugarplumFairySprite extends MobSprite {
	
	//Frames 0,2 are idle, 0,1,2 are moving, 0,3,4,1 are attack and 5,6,7 are for death 
	
	private int[] points = new int[2];

	public SugarplumFairySprite() {
		super();

		texture(Assets.FAIRY);

		TextureFilm frames = new TextureFilm(texture, 15, 15);

		idle = new Animation(2, true);
		idle.frames(frames, 16, 18, 19, 16);

		run = new Animation(8, true);
		run.frames(frames, 16, 17, 18, 16);

		attack = new Animation(8, false);
		attack.frames(frames, 16, 19, 20, 17);

		zap = attack.clone();
		
		die = new Animation(8, false);
		die.frames(frames, 21, 22, 23, 23);

		play(idle);
	}

	@Override
	public void zap(int pos) {

		points[0] = ch.pos;
		points[1] = pos;
		parent.add(new Lightning(points, 2, (SugarplumFairy) ch));

		turnTo(ch.pos, pos);
		play(zap);
	}
	
	@Override
	public int blood() {
		return 0xFFcdcdb7;
	}
}
