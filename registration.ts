/**
 * Created by sm94826 on 6/23/2019.
 */

export class Registration {
  firstName : string;
  lastName : string;
  npiNumber : string;
  address : string;
  phoneNumber: string;
  email:string;

  public constructor( reg:Registration ) {
    Object.assign(this, reg);
  }

}

