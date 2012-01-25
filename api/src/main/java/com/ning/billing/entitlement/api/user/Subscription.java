/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.entitlement.api.user;

import com.ning.billing.catalog.api.BillingPeriod;
import com.ning.billing.catalog.api.Plan;
import com.ning.billing.catalog.api.PlanPhase;
import org.joda.time.DateTime;

import java.util.List;
import java.util.UUID;


public interface Subscription {

    public void cancel(DateTime requestedDate, boolean eot)
    throws EntitlementUserApiException;

    public void uncancel()
    throws EntitlementUserApiException;

    public void changePlan(String productName, BillingPeriod term, String planSet, DateTime requestedDate)
        throws EntitlementUserApiException ;

    public void pause()
        throws EntitlementUserApiException ;

    public void resume()
        throws EntitlementUserApiException ;


    public enum SubscriptionState {
        ACTIVE,
        PAUSED,
        CANCELLED
    }

    public UUID getId();

    public UUID getBundleId();

    public SubscriptionState getState();

    public DateTime getStartDate();

    public DateTime getEndDate();

    public Plan getCurrentPlan();

    public String getCurrentPriceList();

    public PlanPhase getCurrentPhase();
    
    public DateTime getChargedThroughDate();

    public DateTime getPaidThroughDate();


    public List<SubscriptionTransition> getActiveTransitions();

    public List<SubscriptionTransition> getAllTransitions();

    public SubscriptionTransition getPendingTransition();

}
