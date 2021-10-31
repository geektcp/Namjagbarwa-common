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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.InitProducerIdRequestData.*;

public class InitProducerIdRequestDataJsonConverter {
    public static InitProducerIdRequestData read(JsonNode _node, short _version) {
        InitProducerIdRequestData _object = new InitProducerIdRequestData();
        JsonNode _transactionalIdNode = _node.get("transactionalId");
        if (_transactionalIdNode == null) {
            throw new RuntimeException("InitProducerIdRequestData: unable to locate field 'transactionalId', which is mandatory in version " + _version);
        } else {
            if (_transactionalIdNode.isNull()) {
                _object.transactionalId = null;
            } else {
                if (!_transactionalIdNode.isTextual()) {
                    throw new RuntimeException("InitProducerIdRequestData expected a string type, but got " + _node.getNodeType());
                }
                _object.transactionalId = _transactionalIdNode.asText();
            }
        }
        JsonNode _transactionTimeoutMsNode = _node.get("transactionTimeoutMs");
        if (_transactionTimeoutMsNode == null) {
            throw new RuntimeException("InitProducerIdRequestData: unable to locate field 'transactionTimeoutMs', which is mandatory in version " + _version);
        } else {
            _object.transactionTimeoutMs = MessageUtil.jsonNodeToInt(_transactionTimeoutMsNode, "InitProducerIdRequestData");
        }
        JsonNode _producerIdNode = _node.get("producerId");
        if (_producerIdNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("InitProducerIdRequestData: unable to locate field 'producerId', which is mandatory in version " + _version);
            } else {
                _object.producerId = -1L;
            }
        } else {
            _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "InitProducerIdRequestData");
        }
        JsonNode _producerEpochNode = _node.get("producerEpoch");
        if (_producerEpochNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("InitProducerIdRequestData: unable to locate field 'producerEpoch', which is mandatory in version " + _version);
            } else {
                _object.producerEpoch = (short) -1;
            }
        } else {
            _object.producerEpoch = MessageUtil.jsonNodeToShort(_producerEpochNode, "InitProducerIdRequestData");
        }
        return _object;
    }
    public static JsonNode write(InitProducerIdRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_object.transactionalId == null) {
            _node.set("transactionalId", NullNode.instance);
        } else {
            _node.set("transactionalId", new TextNode(_object.transactionalId));
        }
        _node.set("transactionTimeoutMs", new IntNode(_object.transactionTimeoutMs));
        if (_version >= 3) {
            _node.set("producerId", new LongNode(_object.producerId));
        } else {
            if (_object.producerId != -1L) {
                throw new UnsupportedVersionException("Attempted to write a non-default producerId at version " + _version);
            }
        }
        if (_version >= 3) {
            _node.set("producerEpoch", new ShortNode(_object.producerEpoch));
        } else {
            if (_object.producerEpoch != (short) -1) {
                throw new UnsupportedVersionException("Attempted to write a non-default producerEpoch at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(InitProducerIdRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
