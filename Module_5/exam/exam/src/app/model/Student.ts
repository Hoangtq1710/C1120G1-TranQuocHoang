import {Group} from './Group';
import {Teacher} from './Teacher';

export interface Student {
  code:string;
  name:string;
  group:Group;
  subject:string;
  teacher:Teacher;
  email:string;
  phone:string;
}
