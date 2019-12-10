#!/usr/bin/env python3
# Copyright 2017 Google Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import argparse
import locale
import logging
import aiy.voice.tts

from aiy.board import Board, Led
from aiy.cloudspeech import CloudSpeechClient
from googletrans import Translator
#from gtts import gTTS
#from io import BytesIO


'''def get_hints(language_code):
    if language_code.startswith('en_'):
        return ('turn on the light',
                'turn off the light',
                'blink the light',
                'goodbye')
    return None'''

'''def locale_language():
    language, _ = locale.getdefaultlocale()
    return language'''

def main():
    logging.basicConfig(level=logging.DEBUG)

    parser = argparse.ArgumentParser(description='Assistant service example.')
    #parser.add_argument('--language', default=locale_language())
    args = parser.parse_args()

    #logging.info('Initializing for language %s...', args.language)
    #hints = get_hints(args.language)
    client = CloudSpeechClient()
    foreign_language_detected = ''
    language_code = 'en_US'

    alternative_language_codes_element = 'es-MX'
    alternative_language_codes_element_2 = 'de-DE'
    alternative_language_codes_element_3 = 'fr-CA'
    alternative_language_codes = [
        alternative_language_codes_element,
        alternative_language_codes_element_2,
        alternative_language_codes_element_3,
        ]

    
    with Board() as board:
        while True:
            logging.info('Press the button and speak')
            board.button.wait_for_press()
            board.led.state = Led.ON
            '''if hints:
                logging.info('Say something, e.g. %s.' % ', '.join(hints))
            else:
                logging.info('Say something.')
            text = client.recognize(config,
                                    hint_phrases=hints)'''
            text = client.recognize(language_code=language_code, alternative_language_codes=alternative_language_codes)
            translator = Translator()
            if text is None:
                logging.info('You said nothing.')
                board.led.state = Led.OFF
                continue

            logging.info('You said: "%s"' % text)
            text = text.lower()
            board.led.state = Led.OFF
            language_detected = translator.detect(text).lang
            if language_detected != 'en':
                    text_translated_1 = translator.translate(text, dest='en', src='auto')
                    print (text_translated_1.text)
                    aiy.voice.tts.say(text_translated_1.text ,volume=35)		    
                    foreign_language_detected = language_detected
                    foreign_language_detected_uni = language_detected + "-" + language_detected.upper()
            elif language_detected == 'en':
                    if foreign_language_detected != '':
                            text_translated_2 = translator.translate(text, dest=foreign_language_detected, src='auto')
                            print (text_translated_2.text)
                            aiy.voice.tts.say(text_translated_2.text, lang=foreign_language_detected_uni, volume=35)
                    else:
                        aiy.voice.tts.say('you said' + text, lang='en-US', volume=35)
            if 'turn on the light' in text:
                board.led.state = Led.ON
            elif 'turn off the light' in text:
                board.led.state = Led.OFF
            elif 'blink the light' in text:
                board.led.state = Led.BLINK
            elif 'goodbye' in text:
                break

if __name__ == '__main__':
    main()

