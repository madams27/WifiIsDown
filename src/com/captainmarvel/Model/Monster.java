package com.captainmarvel.Model;

import java.util.HashMap;
import com.captainmarvel.Exceptions.*;

public class Monster
{
    private String monsterID;
    private String monsterName;
    private String monsterDescription;
    private String monsterAttackPhrase;
    private int monsterHealth;
    private int monsterAttack;
    private int minEncounterValue;
    private int maxEncounterValue;
    private Item heldItem;

    public static HashMap<String, Monster> allMonsters;

    public Monster(String monsterID, String monsterName, String monsterDescription, String monsterAttackPhrase,
                   int monsterHealth, int monsterAttack, int minEcnounter, int maxEncounter, Item heldItem)
    {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
        this.monsterAttackPhrase = monsterAttackPhrase;
        this.monsterHealth = monsterHealth;
        this.monsterAttack = monsterAttack;
        this.minEncounterValue = minEcnounter;
        this.maxEncounterValue = maxEncounter;
        this.heldItem = heldItem;
    }

    public String getMonsterID()
    {
        return monsterID;
    }

    public void setMonsterID(String monsterID)
    {
        this.monsterID = monsterID;
    }

    public String getMonsterName()
    {
        return monsterName;
    }

    public void setMonsterName(String monsterName)
    {
        this.monsterName = monsterName;
    }

    public String getMonsterDescription()
    {
        return monsterDescription;
    }

    public void setMonsterDescription(String monsterDescription)
    {
        this.monsterDescription = monsterDescription;
    }

    public String getMonsterAttackPhrase()
    {
        return monsterAttackPhrase;
    }

    public void setMonsterAttackPhrase(String monsterAttackPhrase)
    {
        this.monsterAttackPhrase = monsterAttackPhrase;
    }

    public int getMonsterHealth()
    {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth)
    {
        this.monsterHealth = monsterHealth;
    }

    public Item getHeldItem()
    {
        return heldItem;
    }

    public void setHeldItem(Item heldItem)
    {
        this.heldItem = heldItem;
    }

    public String inspectMonster()
    {
        return getMonsterDescription();
    }

    public int getMonsterAttack()
    {
        return monsterAttack;
    }

    public void setMonsterAttack(int monsterAttack)
    {
        this.monsterAttack = monsterAttack;
    }

    public int getMinEncounterValue()
    {
        return minEncounterValue;
    }

    public void setMinEncounterValue(int minEncounterValue)
    {
        this.minEncounterValue = minEncounterValue;
    }

    public int getMaxEncounterValue()
    {
        return maxEncounterValue;
    }

    public void setMaxEncounterValue(int maxEncounterValue)
    {
        this.maxEncounterValue = maxEncounterValue;
    }

    public int attack()
    {
        return getMonsterAttack();
    }

    public void receiveDamage(int damage)
    {
        monsterHealth -= damage;
        if(monsterHealth <= 0)
            throw new MonsterDeathException(monsterName);
    }

    public static void generateMonsters()
    {
        /*
        Waiting for Item class...
         */
    }

}
