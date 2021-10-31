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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.SaslAuthenticateResponseData.*;

public class SaslAuthenticateResponseDataJsonConverter {
    public static SaslAuthenticateResponseData read(JsonNode _node, short _version) {
        SaslAuthenticateResponseData _object = new SaslAuthenticateResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("SaslAuthenticateResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "SaslAuthenticateResponseData");
        }
        JsonNode _errorMessageNode = _node.get("errorMessage");
        if (_errorMessageNode == null) {
            throw new RuntimeException("SaslAuthenticateResponseData: unable to locate field 'errorMessage', which is mandatory in version " + _version);
        } else {
            if (_errorMessageNode.isNull()) {
                _object.errorMessage = null;
            } else {
                if (!_errorMessageNode.isTextual()) {
                    throw new RuntimeException("SaslAuthenticateResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.errorMessage = _errorMessageNode.asText();
            }
        }
        JsonNode _authBytesNode = _node.get("authBytes");
        if (_authBytesNode == null) {
            throw new RuntimeException("SaslAuthenticateResponseData: unable to locate field 'authBytes', which is mandatory in version " + _version);
        } else {
            _object.authBytes = MessageUtil.jsonNodeToBinary(_authBytesNode, "SaslAuthenticateResponseData");
        }
        JsonNode _sessionLifetimeMsNode = _node.get("sessionLifetimeMs");
        if (_sessionLifetimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("SaslAuthenticateResponseData: unable to locate field 'sessionLifetimeMs', which is mandatory in version " + _version);
            } else {
                _object.sessionLifetimeMs = 0L;
            }
        } else {
            _object.sessionLifetimeMs = MessageUtil.jsonNodeToLong(_sessionLifetimeMsNode, "SaslAuthenticateResponseData");
        }
        return _object;
    }
    public static JsonNode write(SaslAuthenticateResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_object.errorMessage == null) {
            _node.set("errorMessage", NullNode.instance);
        } else {
            _node.set("errorMessage", new TextNode(_object.errorMessage));
        }
        _node.set("authBytes", new BinaryNode(Arrays.copyOf(_object.authBytes, _object.authBytes.length)));
        if (_version >= 1) {
            _node.set("sessionLifetimeMs", new LongNode(_object.sessionLifetimeMs));
        }
        return _node;
    }
    public static JsonNode write(SaslAuthenticateResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
