package com.example.lab_6

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class WizardTest {
    private lateinit var evilWizard: Wizard

    // Set up a new wizard before every single test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

        assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
    }

    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5 // Evil Wizard does not have enough mana to cast "Explosion"
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)

        assertEquals(5, evilWizard.mana) // mana still is 5
    }

    @Test
    fun castSpell_frostbite_successful() {
        evilWizard.mana = 420
        evilWizard.spellPower = 69

        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(138, damageDealt)
        assertEquals(415, evilWizard.mana)
    }

    @Test
    fun castSpell_frostbite_unsuccessful() {
        evilWizard.mana = 67

        val damageDealt = evilWizard.castSpell("UnknownSpell")

        assertEquals(0, damageDealt)
        assertEquals(67, evilWizard.mana)
    }
}
