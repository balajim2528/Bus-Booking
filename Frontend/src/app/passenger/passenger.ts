import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TicketResponse } from '../services/passenger';
import { PassengerService } from '../services/passenger';

@Component({
  selector: 'app-passenger',
  imports: [ReactiveFormsModule],
  templateUrl: './passenger.html',
  styleUrl: './passenger.css',
})
export class Passenger {

userForm!:FormGroup;
 
constructor(private fb:FormBuilder,  private passengerService: PassengerService
){

}


 ngOnInit():void{

  this.userForm=this.fb.group({
   
   name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    from: ['', Validators.required],
    to: ['', Validators.required],
    doj: ['', Validators.required],
    trainNum: ['', [
      Validators.required,
      Validators.pattern(/^[0-9]{5}$/)
    ]]

  })
}
message = '';
  onSubmit(): void {
  if (this.userForm.invalid) {
    this.userForm.markAllAsTouched();
    return;
  }

  const data = this.userForm.getRawValue();

  console.log('Sending data:', data);

  this.passengerService.bookTicket(data).subscribe({
    next: (response: TicketResponse) => {
      console.log('Booking response:', response);
      this.message = 'Ticket booked successfully!';
    },
    error: (error: unknown) => {
      console.error('Booking error:', error);
      this.message = 'Ticket booking failed!';
    }
 
})

  }

}

