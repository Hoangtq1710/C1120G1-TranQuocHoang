import { AbstractControl } from '@angular/forms';

export function birthdayValidate(control: AbstractControl) {
  let currentDay = new Date();
  let birthday = new Date(control.value)
  if (birthday > currentDay) {
    return { birthdayValid : true };
  }
  return false;
}
