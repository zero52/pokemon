package com.zhu.modules.pokemon.service;

import com.zhu.modules.pokemon.dao.PokemonDao;
import com.zhu.modules.pokemon.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class PokemonService {

	@Autowired
	private PokemonDao pokemonDao;

	public List<Pokemon> findAll(Pokemon entity){
	    return pokemonDao.findList(entity);
    }

    @Transactional(readOnly = false)
    public void addPokemon(Pokemon pokemon) {
        pokemon.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        pokemon.setTotal(pokemon.getAtk()+pokemon.getDef()+pokemon.getHp()+pokemon.getSat()+pokemon.getSdf()+pokemon.getSpd());
        pokemonDao.insert(pokemon);
    }

    public Pokemon get(Pokemon pokemon) {
	    return pokemonDao.get(pokemon);
    }
	
	/*public int test(){
		Pokemon entity = new Pokemon();
		List<Pokemon> list = pokemonDao.findList(entity);
		int count = 0;
		for(Pokemon p : list){
			p.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			String type = p.getType();
			type.replace("一般", "1,");
			type.replace("格斗", "2,");
			type.replace("飞行", "3,");
			type.replace("毒", "4,");
			type.replace("地面", "5,");
			type.replace("岩石", "6,");
			type.replace("虫", "7,");
			type.replace("幽灵", "8,");
			type.replace("钢", "9,");
			type.replace("火", "10,");
			type.replace("水", "11,");
			type.replace("草", "12,");
			type.replace("电", "13,");
			type.replace("超能力", "14,");
			type.replace("冰", "15,");
			type.replace("龙", "16,");
			type.replace("恶", "17,");
			type.replace("妖精", "18,");
			p.setType(type);
			pokemonDao.update(p);
			count++;
		}
		return count;
	}*/

}
