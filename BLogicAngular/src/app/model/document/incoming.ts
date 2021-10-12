import { Person } from "src/app/model/person/person";
import {Document} from "./document";

export class Incoming extends Document {
  sender: Person;
  addressee: Person;
  outgoingNumber: number;
  outgoingDateOfRegistration: Date;

  constructor(id: string,
              name: string,
              text: string,
              registrationNumber: number,
              dateOfRegistration: Date,
              author: Person,
              sender: Person,
              addressee: Person,
              outgoingNumber: number,
              outgoingDateOfRegistration: Date) {
    super(id, name, text, registrationNumber, dateOfRegistration, author);
    this.sender = sender;
    this.addressee = addressee;
    this.outgoingNumber = outgoingNumber;
    this.outgoingDateOfRegistration = outgoingDateOfRegistration;
  }
}
