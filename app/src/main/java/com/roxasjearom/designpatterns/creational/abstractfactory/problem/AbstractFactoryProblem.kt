package com.roxasjearom.designpatterns.creational.abstractfactory.problem

//Product interfaces
interface Button {
    fun render()
}

interface TextField {
    fun render()
}

//Concrete product families
class BigButton : Button {
    override fun render() {
        println("Rendering big button")
    }
}
class BigTextField : TextField {
    override fun render() {
        println("Rendering big text field")
    }
}

class SmallButton : Button {
    override fun render() {
        println("Rendering small button")
    }
}
class SmallTextField : TextField {
    override fun render() {
        println("Rendering small text field")
    }
}

enum class UiType {
    BIG, SMALL
}

/*
This client directly creates type-specific components, making it tightly coupled to the concrete classes.
This code violates the Open/Closed Principle because we have to modify this client when we add a new type of UI.
 */
private class SampleScreen(val uiType: UiType) {
    fun createUi() {
        val button = when (uiType) {
            UiType.BIG -> BigButton()
            UiType.SMALL -> SmallButton()
        }
        val textField = when (uiType) {
            UiType.BIG -> BigTextField()
            UiType.SMALL -> SmallTextField()
        }
        button.render()
        textField.render()
    }
}
