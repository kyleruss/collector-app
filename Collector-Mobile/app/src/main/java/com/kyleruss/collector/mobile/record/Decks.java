package com.kyleruss.collector.mobile.record;

import org.json.JSONObject;

public class Decks implements RecordTranslator<Decks>
{
    private int id;
    private String name;
    private String description;
    private User owner;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public Decks mapToRecord(JSONObject obj)
    {
        return null;
    }

    @Override
    public JSONObject serializeRecord()
    {
        return null;
    }
}
