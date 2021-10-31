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

import static org.apache.kafka.common.message.InitProducerIdResponseData.*;

public class InitProducerIdResponseDataJsonConverter {
    public static InitProducerIdResponseData read(JsonNode _node, short _version) {
        InitProducerIdResponseData _object = new InitProducerIdResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("InitProducerIdResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "InitProducerIdResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("InitProducerIdResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "InitProducerIdResponseData");
        }
        JsonNode _producerIdNode = _node.get("producerId");
        if (_producerIdNode == null) {
            throw new RuntimeException("InitProducerIdResponseData: unable to locate field 'producerId', which is mandatory in version " + _version);
        } else {
            _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "InitProducerIdResponseData");
        }
        JsonNode _producerEpochNode = _node.get("producerEpoch");
        if (_producerEpochNode == null) {
            throw new RuntimeException("InitProducerIdResponseData: unable to locate field 'producerEpoch', which is mandatory in version " + _version);
        } else {
            _object.producerEpoch = MessageUtil.jsonNodeToShort(_producerEpochNode, "InitProducerIdResponseData");
        }
        return _object;
    }
    public static JsonNode write(InitProducerIdResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        _node.set("errorCode", new ShortNode(_object.errorCode));
        _node.set("producerId", new LongNode(_object.producerId));
        _node.set("producerEpoch", new ShortNode(_object.producerEpoch));
        return _node;
    }
    public static JsonNode write(InitProducerIdResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
