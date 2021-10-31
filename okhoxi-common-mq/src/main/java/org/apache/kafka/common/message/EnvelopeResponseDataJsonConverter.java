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
import com.fasterxml.jackson.databind.node.ShortNode;
import java.nio.ByteBuffer;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.EnvelopeResponseData.*;

public class EnvelopeResponseDataJsonConverter {
    public static EnvelopeResponseData read(JsonNode _node, short _version) {
        EnvelopeResponseData _object = new EnvelopeResponseData();
        JsonNode _responseDataNode = _node.get("responseData");
        if (_responseDataNode == null) {
            throw new RuntimeException("EnvelopeResponseData: unable to locate field 'responseData', which is mandatory in version " + _version);
        } else {
            if (_responseDataNode.isNull()) {
                _object.responseData = null;
            } else {
                _object.responseData = ByteBuffer.wrap(MessageUtil.jsonNodeToBinary(_responseDataNode, "EnvelopeResponseData"));
            }
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("EnvelopeResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "EnvelopeResponseData");
        }
        return _object;
    }
    public static JsonNode write(EnvelopeResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_object.responseData == null) {
            _node.set("responseData", NullNode.instance);
        } else {
            _node.set("responseData", new BinaryNode(MessageUtil.byteBufferToArray(_object.responseData)));
        }
        _node.set("errorCode", new ShortNode(_object.errorCode));
        return _node;
    }
    public static JsonNode write(EnvelopeResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
