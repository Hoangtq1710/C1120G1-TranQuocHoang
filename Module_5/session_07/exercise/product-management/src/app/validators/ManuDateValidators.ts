import { AbstractControl } from '@angular/forms';

export function validateManuDate(control: AbstractControl) {

  let currentDay = new Date();
  let manuDate = new Date(control.value)
  if (manuDate > currentDay) {
    return { dateValid : true };
  }
  return false;
}
