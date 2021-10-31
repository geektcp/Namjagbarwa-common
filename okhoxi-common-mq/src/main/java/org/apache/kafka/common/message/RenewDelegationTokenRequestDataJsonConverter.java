/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.RenewDelegationTokenRequestData.*;

public class RenewDelegationTokenRequestDataJsonConverter {
    public static RenewDelegationTokenRequestData read(JsonNode _node, short _version) {
        RenewDelegationTokenRequestData _object = new RenewDelegationTokenRequestData();
        JsonNode _hmacNode = _node.get("hmac");
        if (_hmacNode == null) {
            throw new RuntimeException("RenewDelegationTokenRequestData: unable to locate field 'hmac', which is mandatory in version " + _version);
        } else {
            _object.hmac = MessageUtil.jsonNodeToBinary(_hmacNode, "RenewDelegationTokenRequestData");
        }
        JsonNode _renewPeriodMsNode = _node.get("renewPeriodMs");
        if (_renewPeriodMsNode == null) {
            throw new RuntimeException("RenewDelegationTokenRequestData: unable to locate field 'renewPeriodMs', which is mandatory in version " + _version);
        } else {
            _object.renewPeriodMs = MessageUtil.jsonNodeToLong(_renewPeriodMsNode, "RenewDelegationTokenRequestData");
        }
        return _object;
    }
    public static JsonNode write(RenewDelegationTokenRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("hmac", new BinaryNode(Arrays.copyOf(_object.hmac, _object.hmac.length)));
        _node.set("renewPeriodMs", new LongNode(_object.renewPeriodMs));
        return _node;
    }
    public static JsonNode write(RenewDelegationTokenRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
