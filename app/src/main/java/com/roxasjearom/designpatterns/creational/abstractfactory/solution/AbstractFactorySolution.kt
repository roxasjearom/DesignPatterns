package com.roxasjearom.designpatterns.creational.abstractfactory.solution

import com.roxasjearom.designpatterns.creational.abstractfactory.problem.BigButton
import com.roxasjearom.designpatterns.creational.abstractfactory.problem.BigTextField
import com.roxasjearom.designpatterns.creational.abstractfactory.problem.Button
import com.roxasjearom.designpatterns.creational.abstractfactory.problem.TextField

//Abstract factory interface
interface UiFactory {
    fun createButton(): Button
    fun createTextField(): TextField
}

//Concrete factory implementations
class BigUiFactory : UiFactory {
    override fun createButton(): Button {
        return BigButton()
    }
    override fun createTextField(): TextField {
        return BigTextField()
    }
}
class SmallUiFactory : UiFactory {
    override fun createButton(): Button {
        return BigButton()
    }
    override fun createTextField(): TextField {
        return BigTextField()
    }
}

/*
With the use of abstract factory, we now eliminate the coupling between the client and the concrete classes.
If we add a new type of UI, we do not have to touch this client code, thus adhering to the Open/Closed Principle.
 */
private class SampleScreen(val uiFactory: UiFactory) {
    fun createUi() {
        val button = uiFactory.createButton()
        val textField = uiFactory.createTextField()
        button.render()
        textField.render()
    }
}
