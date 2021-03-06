/*
 * Copyright 2019-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.p4runtime.ctl.controller;

import org.onosproject.net.DeviceId;

import java.math.BigInteger;

/**
 * Store that keeps track of master election IDs for each device.
 */
public interface MasterElectionIdStore {

    /**
     * Sets the master election ID for the given device.
     *
     * @param deviceId   device ID
     * @param electionId election ID
     */
    void set(DeviceId deviceId, BigInteger electionId);

    /**
     * Returns the last known master election ID for the given device, or null.
     *
     * @param deviceId device ID
     * @return election ID
     */
    BigInteger get(DeviceId deviceId);

    /**
     * Removes any state associated with the given device.
     *
     * @param deviceId device ID
     */
    void remove(DeviceId deviceId);

    /**
     * Sets a listener for the given device that will be invoked every time
     * there will be changes to the master election ID.
     *
     * @param deviceId device ID
     * @param listener listener
     */
    void setListener(DeviceId deviceId, MasterElectionIdListener listener);

    /**
     * Unset the listener for the given device.
     *
     * @param deviceId device ID
     */
    void unsetListener(DeviceId deviceId);

    /**
     * Listener of master election ID changes for a specific device.
     */
    interface MasterElectionIdListener {

        /**
         * Notifies that the master election ID has been updated to the given
         * (nullable) value.
         *
         * @param masterElectionId new master election ID, or null
         */
        void updated(BigInteger masterElectionId);
    }
}
