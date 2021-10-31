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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AddOffsetsToTxnRequestData.*;

public class AddOffsetsToTxnRequestDataJsonConverter {
    public static AddOffsetsToTxnRequestData read(JsonNode _node, short _version) {
        AddOffsetsToTxnRequestData _object = new AddOffsetsToTxnRequestData();
        JsonNode _transactionalIdNode = _node.get("transactionalId");
        if (_transactionalIdNode == null) {
            throw new RuntimeException("AddOffsetsToTxnRequestData: unable to locate field 'transactionalId', which is mandatory in version " + _version);
        } else {
            if (!_transactionalIdNode.isTextual()) {
                throw new RuntimeException("AddOffsetsToTxnRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.transactionalId = _transactionalIdNode.asText();
        }
        JsonNode _producerIdNode = _node.get("producerId");
        if (_producerIdNode == null) {
            throw new RuntimeException("AddOffsetsToTxnRequestData: unable to locate field 'producerId', which is mandatory in version " + _version);
        } else {
            _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "AddOffsetsToTxnRequestData");
        }
        JsonNode _producerEpochNode = _node.get("producerEpoch");
        if (_producerEpochNode == null) {
            throw new RuntimeException("AddOffsetsToTxnRequestData: unable to locate field 'producerEpoch', which is mandatory in version " + _version);
        } else {
            _object.producerEpoch = MessageUtil.jsonNodeToShort(_producerEpochNode, "AddOffsetsToTxnRequestData");
        }
        JsonNode _groupIdNode = _node.get("groupId");
        if (_groupIdNode == null) {
            throw new RuntimeException("AddOffsetsToTxnRequestData: unable to locate field 'groupId', which is mandatory in version " + _version);
        } else {
            if (!_groupIdNode.isTextual()) {
                throw new RuntimeException("AddOffsetsToTxnRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.groupId = _groupIdNode.asText();
        }
        return _object;
    }
    public static JsonNode write(AddOffsetsToTxnRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("transactionalId", new TextNode(_object.transactionalId));
        _node.set("producerId", new LongNode(_object.producerId));
        _node.set("producerEpoch", new ShortNode(_object.producerEpoch));
        _node.set("groupId", new TextNode(_object.groupId));
        return _node;
    }
    public static JsonNode write(AddOffsetsToTxnRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
