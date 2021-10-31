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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.EndTxnRequestData.*;

public class EndTxnRequestDataJsonConverter {
    public static EndTxnRequestData read(JsonNode _node, short _version) {
        EndTxnRequestData _object = new EndTxnRequestData();
        JsonNode _transactionalIdNode = _node.get("transactionalId");
        if (_transactionalIdNode == null) {
            throw new RuntimeException("EndTxnRequestData: unable to locate field 'transactionalId', which is mandatory in version " + _version);
        } else {
            if (!_transactionalIdNode.isTextual()) {
                throw new RuntimeException("EndTxnRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.transactionalId = _transactionalIdNode.asText();
        }
        JsonNode _producerIdNode = _node.get("producerId");
        if (_producerIdNode == null) {
            throw new RuntimeException("EndTxnRequestData: unable to locate field 'producerId', which is mandatory in version " + _version);
        } else {
            _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "EndTxnRequestData");
        }
        JsonNode _producerEpochNode = _node.get("producerEpoch");
        if (_producerEpochNode == null) {
            throw new RuntimeException("EndTxnRequestData: unable to locate field 'producerEpoch', which is mandatory in version " + _version);
        } else {
            _object.producerEpoch = MessageUtil.jsonNodeToShort(_producerEpochNode, "EndTxnRequestData");
        }
        JsonNode _committedNode = _node.get("committed");
        if (_committedNode == null) {
            throw new RuntimeException("EndTxnRequestData: unable to locate field 'committed', which is mandatory in version " + _version);
        } else {
            if (!_committedNode.isBoolean()) {
                throw new RuntimeException("EndTxnRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.committed = _committedNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(EndTxnRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("transactionalId", new TextNode(_object.transactionalId));
        _node.set("producerId", new LongNode(_object.producerId));
        _node.set("producerEpoch", new ShortNode(_object.producerEpoch));
        _node.set("committed", BooleanNode.valueOf(_object.committed));
        return _node;
    }
    public static JsonNode write(EndTxnRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
