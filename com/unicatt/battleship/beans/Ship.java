package com.unicatt.battleship.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ship implements IDamageable
{
    /** The components attached to this ship */
    private ArrayList<ShipComponent> shipComponents;

    public Ship(List<ShipComponent> shipComponents)
    {
        this.attachComponents(shipComponents);
    }

    public Ship(ShipComponent... args)
    {
        this.attachComponents(List.of(args));
    }

    public void attachComponent(ShipComponent component)
    {
        component.setParentShip(this);
        shipComponents.add(component);
    }

    public void attachComponents(List<ShipComponent> components)
    {
        int componentsNum = components.size();
        shipComponents = new ArrayList<>(Collections.nCopies(componentsNum, null));

        for(int i = 0; i < componentsNum; i++)
        {
            ShipComponent component = components.get(i);
            component.setParentShip(this);
            shipComponents.set(i, component);
        }
    }

    public List<ShipComponent> getShipComponents()
    {
        return shipComponents;
    }

    public boolean isDestroyed()
    {
        boolean isDestroyed = true;
        for(ShipComponent shipComponent : shipComponents)
        {
            if(!shipComponent.isHit())
            {
                isDestroyed = false;
                break;
            }
        }
        return isDestroyed;
    }

    @Override
    public void OnReceiveHit()
    {
        if(isDestroyed())
        {

        }
    }
}
