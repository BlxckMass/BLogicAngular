import {Document} from "./document";
import {Person} from "../person/person";

export class Outgoing extends Document {

  addressee: Person;
  deliveryMethod: string;

  constructor(id: string,
              name: string,
              text: string,
              registrationNumber: number,
              dateOfRegistration: Date,
              author: Person,
              addressee: Person,
              deliveryMethod: string) {
    super(id, name, text, registrationNumber, dateOfRegistration, author);
    this.addressee = addressee;
    this.deliveryMethod = deliveryMethod;
  }
}
