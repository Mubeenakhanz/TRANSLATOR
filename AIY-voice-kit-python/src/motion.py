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

"""A demo of motion."""

import aiy.audio
import aiy.cloudspeech
import aiy.voicehat

def main():
    '''Start voice recognition when motion is detected'''
    #my_motion_detector = MotionDetector()
    recognizer = aiy.cloudspeech.get_recognizer()
    button = aiy.voicehat.get_button()
    led = aiy.voicehat.get_led()
    aiy.audio.get_recorder().start()
    while True:
        #my_motion_detector.WaitForMotion()
        print('Press the button and speak')
        button.wait_for_press()
        print('Listening...')
        text = recognizer.recognize()
        print('You said "', text, '"')
        aiy.audio.say('You said "' + text + '"', lang="en-US", volume=5, pitch=135)
        
if __name__ == '__main__':
    main()