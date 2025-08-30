package com.roxasjearom.designpatterns.creational.factorymethod.problem

//Product
interface Subscription {
    fun subscribe()
}

//Concrete Product
class BasicSubscription : Subscription {
    override fun subscribe() {
        println("Subscribed to Basic Subscription")
    }
}

class StandardSubscription : Subscription {
    override fun subscribe() {
        println("Subscribed to Standard Subscription")
    }
}

class PremiumSubscription : Subscription {
    override fun subscribe() {
        println("Subscribed to Premium Subscription")
    }
}

enum class SubscriptionType {
    BASIC, STANDARD, PREMIUM
}

/* The problem is the clients are directly responsible for creating instances of the products.
This leads to tight coupling and violates the Open/Closed Principle. */
private class FirstViewModel {
    fun subscribe(subscriptionType: SubscriptionType) {
        val subscription = when (subscriptionType) {
            SubscriptionType.BASIC -> BasicSubscription()
            SubscriptionType.STANDARD -> StandardSubscription()
            SubscriptionType.PREMIUM -> PremiumSubscription()
        }
        subscription.subscribe()
    }
}

private class SecondViewModel {
    fun subscribe(subscriptionType: SubscriptionType) {
        val subscription = when (subscriptionType) {
            SubscriptionType.BASIC -> BasicSubscription()
            SubscriptionType.STANDARD -> StandardSubscription()
            SubscriptionType.PREMIUM -> PremiumSubscription()
        }
        subscription.subscribe()
    }
}
