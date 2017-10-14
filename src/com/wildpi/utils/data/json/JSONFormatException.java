/*
 *  Copyright 2017 Alex Anderson
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

package com.wildpi.utils.data.json;

/**
 * Thrown to signal that a string of JSON was not properly formatted.
 *
 * @author Alex
 */
public class JSONFormatException extends RuntimeException
{
    /**
     * @param message A programmer friendly message
     */
    public JSONFormatException(String message)
    {
        super(message);
    }

    /**
     * @param throwable The exception/error which caused this exception
     */
    public JSONFormatException(Throwable throwable)
    {
        super(throwable);
    }

    /**
     * @param message   A programmer friendly message
     * @param throwable The exception/error which caused this exception
     */
    public JSONFormatException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}