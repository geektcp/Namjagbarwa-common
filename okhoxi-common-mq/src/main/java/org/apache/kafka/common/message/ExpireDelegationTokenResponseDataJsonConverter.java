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
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.ExpireDelegationTokenResponseData.*;

public class ExpireDelegationTokenResponseDataJsonConverter {
    public static ExpireDelegationTokenResponseData read(JsonNode _node, short _version) {
        ExpireDelegationTokenResponseData _object = new ExpireDelegationTokenResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("ExpireDelegationTokenResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "ExpireDelegationTokenResponseData");
        }
        JsonNode _expiryTimestampMsNode = _node.get("expiryTimestampMs");
        if (_expiryTimestampMsNode == null) {
            throw new RuntimeException("ExpireDelegationTokenResponseData: unable to locate field 'expiryTimestampMs', which is mandatory in version " + _version);
        } else {
            _object.expiryTimestampMs = MessageUtil.jsonNodeToLong(_expiryTimestampMsNode, "ExpireDelegationTokenResponseData");
        }
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("ExpireDelegationTokenResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "ExpireDelegationTokenResponseData");
        }
        return _object;
    }
    public static JsonNode write(ExpireDelegationTokenResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        _node.set("expiryTimestampMs", new LongNode(_object.expiryTimestampMs));
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        return _node;
    }
    public static JsonNode write(ExpireDelegationTokenResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
