package com.roxasjearom.designpatterns.creational.factorymethod.solution

import com.roxasjearom.designpatterns.creational.factorymethod.problem.BasicSubscription
import com.roxasjearom.designpatterns.creational.factorymethod.problem.PremiumSubscription
import com.roxasjearom.designpatterns.creational.factorymethod.problem.StandardSubscription
import com.roxasjearom.designpatterns.creational.factorymethod.problem.Subscription
import com.roxasjearom.designpatterns.creational.factorymethod.problem.SubscriptionType

//Factory method
object SubscriptionFactory {
    fun createSubscription(subscriptionType: SubscriptionType): Subscription {
        return when (subscriptionType) {
            SubscriptionType.BASIC -> BasicSubscription()
            SubscriptionType.STANDARD -> StandardSubscription()
            SubscriptionType.PREMIUM -> PremiumSubscription()
        }
    }
}

/*
With Factory method, the clients are not directly responsible for creating instances of the products.
It is also free from being modified when a new subscription type is added.
 */
//Clients
private class FirstViewModel {
    fun subscribe(subscriptionType: SubscriptionType) {
        val subscription = SubscriptionFactory.createSubscription(subscriptionType)
        subscription.subscribe()
    }
}

private class SecondViewModel {
    fun subscribe(subscriptionType: SubscriptionType) {
        val subscription = SubscriptionFactory.createSubscription(subscriptionType)
        subscription.subscribe()
    }
}
