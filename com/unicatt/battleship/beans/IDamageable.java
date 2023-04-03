package com.unicatt.battleship.beans;

@FunctionalInterface
public interface IDamageable
{
    /** Called when a damageable object gets hit. */
    void OnReceiveHit();
}
