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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.EnvelopeRequestData.*;

public class EnvelopeRequestDataJsonConverter {
    public static EnvelopeRequestData read(JsonNode _node, short _version) {
        EnvelopeRequestData _object = new EnvelopeRequestData();
        JsonNode _requestDataNode = _node.get("requestData");
        if (_requestDataNode == null) {
            throw new RuntimeException("EnvelopeRequestData: unable to locate field 'requestData', which is mandatory in version " + _version);
        } else {
            _object.requestData = ByteBuffer.wrap(MessageUtil.jsonNodeToBinary(_requestDataNode, "EnvelopeRequestData"));
        }
        JsonNode _requestPrincipalNode = _node.get("requestPrincipal");
        if (_requestPrincipalNode == null) {
            throw new RuntimeException("EnvelopeRequestData: unable to locate field 'requestPrincipal', which is mandatory in version " + _version);
        } else {
            if (_requestPrincipalNode.isNull()) {
                _object.requestPrincipal = null;
            } else {
                _object.requestPrincipal = MessageUtil.jsonNodeToBinary(_requestPrincipalNode, "EnvelopeRequestData");
            }
        }
        JsonNode _clientHostAddressNode = _node.get("clientHostAddress");
        if (_clientHostAddressNode == null) {
            throw new RuntimeException("EnvelopeRequestData: unable to locate field 'clientHostAddress', which is mandatory in version " + _version);
        } else {
            _object.clientHostAddress = MessageUtil.jsonNodeToBinary(_clientHostAddressNode, "EnvelopeRequestData");
        }
        return _object;
    }
    public static JsonNode write(EnvelopeRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("requestData", new BinaryNode(MessageUtil.byteBufferToArray(_object.requestData)));
        if (_object.requestPrincipal == null) {
            _node.set("requestPrincipal", NullNode.instance);
        } else {
            _node.set("requestPrincipal", new BinaryNode(Arrays.copyOf(_object.requestPrincipal, _object.requestPrincipal.length)));
        }
        _node.set("clientHostAddress", new BinaryNode(Arrays.copyOf(_object.clientHostAddress, _object.clientHostAddress.length)));
        return _node;
    }
    public static JsonNode write(EnvelopeRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
